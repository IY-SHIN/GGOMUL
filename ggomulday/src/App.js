import { Routes, Route } from 'react-router-dom';
import Login from './pages/Login/Login';
import Select from './pages/Register/Select';
import Register from './pages/Register/Register';

function App() {
  return (
    <Routes>
      <Route path="/Login" element={<Login />} />
      <Route path="/Register" element={<Select />} />
      <Route path="/Register/:type" element={<Register />} />
    </Routes>
  );
}

export default App;
