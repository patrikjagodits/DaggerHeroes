import { Routes, Route } from 'react-router-dom'
import HomePage from './pages/HomePage'
import CharacterCreatorPage from './pages/CharacterCreatorPage'
import { CharacterProvider } from './context/CharacterContext'

function App() {
  return(
    <CharacterProvider>
      <div>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/creator" element={<CharacterCreatorPage />} />
        </Routes>
      </div>
    </CharacterProvider>
  )
}

export default App