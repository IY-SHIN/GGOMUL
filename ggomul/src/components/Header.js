import React from "react";
import {GoThreeBars} from 'react-icons/go';
import { useNavigate } from "react-router-dom";

const Header = () => {
    const navigate = useNavigate();

    return (
    <div className="header">
        
        <div className="logo">GGOMUL</div>
    
        <div className="header_option">
        <span className="login" onClick={() => navigate("/login")}>로그인</span>
        <span className="join" onClick={() => navigate("/")}>회원가입</span>
        <span className="icon"><GoThreeBars/></span>
        </div>

    </div>
        
    )
    };

export default Header;