import React, { useState } from "react";
import {useNavigate } from "react-router-dom";

const Header = () => {
    const navigate = useNavigate();
    const [click, setClick] = useState(false);
    const handleClick = () =>setClick(!click);

    return (
    <div className="header">

        <i className="fas fa-code"></i>
        
        <div className="logo">GGOMUL</div>
    
        <div className="header_option">
        <span  className="header-links" onClick={() => navigate("/login")}>Login</span>
        <span  className="header-links" onClick={() => navigate("/register")}>Join</span>
        </div>

        <span className="nav-icon" onClick={handleClick}>
            <i className={click ? "fas fa-times":"fas fa-bars"}></i>
        </span>

    </div>
        
    )
    };

export default Header;