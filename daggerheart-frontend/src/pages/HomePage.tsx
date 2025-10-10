import React from 'react';
import { Link } from "react-router-dom";

function HomePage(){
    return(
        <div>
            <h1>Welcome to the Daggerheart Character Creator</h1>
            <Link to="/creator">
                <button>New Character</button>
            </Link>
        </div>
        );
    }

export default HomePage;