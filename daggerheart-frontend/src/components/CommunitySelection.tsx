// src/components/CommunitySelection.tsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import type { Community } from '../types';
import { useCharacterBuilder } from '../context/CharacterContext';

interface CommunitySelectionProps {
    onNext: () => void;
    onBack: () => void;
}

export function CommunitySelection({ onNext, onBack }: CommunitySelectionProps) {
    const [communities, setCommunities] = useState<Community[]>([]);
    const { characterData, setCharacterData } = useCharacterBuilder();

    useEffect(() => {
        axios.get<Community[]>('/api/gamedata/communities')
            .then(response => setCommunities(response.data))
            .catch(error => console.error("Failed to fetch communities", error));
    }, []);

    const handleSelect = (id: string) => {
        const selected = communities.find(c => c.id === parseInt(id));
        setCharacterData(prev => ({ ...prev, community: selected || null }));
    };
    
    return (
        <div>
            <h2>4. Choose your Community</h2>
            <select onChange={(e) => handleSelect(e.target.value)} value={characterData.community?.id || ""}>
                <option value="">-- Select a Community --</option>
                {communities.map(c => <option key={c.id} value={c.id}>{c.name}</option>)}
            </select>
            <p>{characterData.community?.description}</p>
            <div>
                <button onClick={onBack}>Back</button>
                <button onClick={onNext} disabled={!characterData.community}>Next</button>
            </div>
        </div>
    );
}