import React from 'react';
import { Route, Routes } from 'react-router-dom';
import "./asset/style.scss";
import Home from "./components/Home";
import Login from './pages/Login/Login';
import Select from './pages/Register/Select';
import Register from './pages/Register/Register';
import Mypage from './pages/Mypage/Mypage';
// import modalTest from "./components/modalTest"


function App() {
  //  // useState를 사용하여 open상태를 변경한다. (open일때 true로 만들어 열리는 방식)
  //  const [modalOpen, setModalOpen] = useState(false);

  //  const openModal = () => {
  //    setModalOpen(true);
  //  };
  //  const closeModal = () => {
  //    setModalOpen(false);
  //  };

  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Select />} />
      <Route path="/register/:type" element={<Register />} />
      <Route path="/mypage" element={<Mypage />} />
    </Routes>
  )
}

export default App;

