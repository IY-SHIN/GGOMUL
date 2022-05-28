import './Login.scss';

function Login() {
    return (
        <div className="container">
            <div>
                <div className="login-head">꼬물이</div>
                <input className="login-input" placeholder="아이디" />
                <input className="login-input" placeholder="비밀번호" />
                <div className="login-forgot">비밀번호 잊어버림</div>
                <button className="login-button" shape="green-fill" type="submit">로그인</button>
                <button className="login-register">회원가입</button>
            </div>
        </div>
    );
}

export default Login;