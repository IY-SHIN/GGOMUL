import { useNavigate } from 'react-router-dom';
import './Login.scss';

function Login() {
    const navigate = useNavigate();

    return (
        <div className="login-container">
            <div className="login-box">
                <div className="login-head">꼬물이</div>
                <input placeholder="이메일" />
                <input placeholder="비밀번호" />
                <div className="login-forgot">비밀번호 잊어버림</div>
                <button className="login-button">로그인</button>
                <button className="login-register"
                    onClick={() => navigate("/Register")}>회원가입</button>
            </div>

            <div className="social-box">
                <button className="social-naver">네이버</button>
                <button className="social-google">구글</button>
                <button className="social-kakao">카카오</button>
            </div>
        </div>
    );
}

export default Login;