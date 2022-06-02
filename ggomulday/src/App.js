import { Routes, Route } from 'react-router-dom';
import Login from './pages/Login/Login';
import Select from './pages/Register/Select';
import Register from './pages/Register/Register';
import Mypage from './pages/Mypage/Mypage';

function App() {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Select />} />
      <Route path="/register/:type" element={<Register />} />
      <Route path="/mypage" element={<Mypage />} />
    </Routes>
  );
}

export default App;
