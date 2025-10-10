import React from 'react';
import { useCharacterBuilder } from '../context/CharacterContext';

interface StatDistributionProps {
    onNext: () => void;
    onBack: () => void;
}

// Define the available scores and the names of the stats
const AVAILABLE_SCORES = [+2, +1, +1, 0, 0, -1];
const STAT_NAMES = ['agility', 'strenght', 'finesse', 'instinct', 'presence', 'knowledge'] as const;

export function StatDistribution({ onNext, onBack }: StatDistributionProps) {
    const { characterData, setCharacterData } = useCharacterBuilder();
    
    // Get the scores that have already been assigned
    const assignedScores = Object.values(characterData.abilityScores).filter(score => score !== null);

    // Create a list of scores that are still available to be assigned
    const remainingScores = AVAILABLE_SCORES.map((score, index) => ({ value: score, id: `${score}_${index}` }));
    assignedScores.forEach(assigned => {
        const indexToRemove = remainingScores.findIndex(rem => rem.value === assigned);
        if (indexToRemove > -1) {
            remainingScores.splice(indexToRemove, 1);
        }
    });

    const handleStatChange = (statName: typeof STAT_NAMES[number], value: string) => {
        const newScore = value === "" ? null : parseInt(value);

        setCharacterData(prev => ({
            ...prev,
            abilityScores: {
                ...prev.abilityScores,
                [statName]: newScore
            }
        }));
    };
    
    // The "Next" button is only enabled if all 6 stats have a score
    const isComplete = Object.values(characterData.abilityScores).every(score => score !== null);

    return (
        <div>
            <h2>5. Distribute Ability Scores</h2>
            <p>Assign one of each score to an ability: <strong>+2, +1, +1, 0, 0, -1</strong></p>
            {STAT_NAMES.map(statName => {
                const currentValue = characterData.abilityScores[statName];
                return (
                    <div key={statName}>
                        <label style={{textTransform: 'capitalize', width: '100px', display: 'inline-block'}}>
                            {statName}
                        </label>
                        <select onChange={(e) => handleStatChange(statName, e.target.value)} value={currentValue ?? ""}>
                            <option value="">--</option>
                            {/* If this stat already has a value, it should be in the list */}
                            {currentValue !== null && <option value={currentValue}>{currentValue > 0 ? `+${currentValue}` : currentValue}</option>}
                            {/* List all remaining, unassigned scores */}
                            {remainingScores.map(score => 
                                <option key={score.id} value={score.value}>{score.value > 0 ? `+${score.value}` : score.value}</option>
                            )}
                        </select>
                    </div>
                );
            })}
             <div>
                <button onClick={onBack}>Back</button>
                <button onClick={onNext} disabled={!isComplete}>Next</button>
            </div>
        </div>
    );
}