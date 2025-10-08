import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { CharacterClass } from './types';

function CharacterCreatorPage() {
    const [classes, setClasses] = useState<CharacterClass[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        axios.get<CharacterClass[]>('/api/gamedata/classes')
            .then(response => {
                setClasses(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error("Error while trying to get data:", error);
                setError("Failed to load classes. Does the backend runs?");
                setLoading(false);
            });
    }, []);

    if (loading) return <p>Loading data...</p>;
    if (error) return <p>{error}</p>;

    return (
        <div>
            <h1>Create new Character</h1>
            <label htmlFor="class-select">Choose a class:</label>
            <select id="class-select">
                <option value="">-- Please choose --</option>
                {classes.map(characterClass => (
                    <option key={characterClass.id} value={characterClass.id}>
                        {characterClass.name}
                    </option>
                ))}
            </select>
        </div>
    );
}

export default CharacterCreatorPage;