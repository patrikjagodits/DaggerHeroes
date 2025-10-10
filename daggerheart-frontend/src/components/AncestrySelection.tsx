import React, { useState, useEffect } from 'react';
import axios from 'axios';
import type { Ancestry } from '../types';
import { useCharacterBuilder } from '../context/CharacterContext';

interface AncestrySelectionProps {
    onNext: () => void;
    onBack: () => void;
}

export function AncestrySelection({ onNext, onBack }: AncestrySelectionProps) {
    const [ancestries, setAncestries] = useState<Ancestry[]>([]);
    const { characterData, setCharacterData } = useCharacterBuilder();

    useEffect(() => {
        axios.get<Ancestry[]>('/api/gamedata/ancestries')
            .then(response => setAncestries(response.data))
            .catch(error => console.error("Failed to fetch ancestries", error));
    }, []);

    const handleSelect = (id: string) => {
        const selected = ancestries.find(a => a.id === parseInt(id));
        setCharacterData(prev => ({ ...prev, ancestry: selected || null }));
    };
    
    return (
        <div>
            <h2>3. Choose your Ancestry</h2>
            <select onChange={(e) => handleSelect(e.target.value)} value={characterData.ancestry?.id || ""}>
                <option value="">-- Select an Ancestry --</option>
                {ancestries.map(a => <option key={a.id} value={a.id}>{a.name}</option>)}
            </select>
            <p>{characterData.ancestry?.description}</p>
            <div>
                <button onClick={onBack}>Back</button>
                <button onClick={onNext} disabled={!characterData.ancestry}>Next</button>
            </div>
        </div>
    );
}