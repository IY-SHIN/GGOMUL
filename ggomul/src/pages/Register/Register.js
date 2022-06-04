import { useParams } from 'react-router-dom';
import './Register.scss';

function Register() {
    const { type } = useParams();

    return (
        <div className="join-container">
            <div className="join-box">
                <input placeholder="이름" />
                <input placeholder="성별" />
                <input placeholder="이메일" />
                <input placeholder="아이디" />
                <input placeholder="비밀번호" />
                <input placeholder="비밀번호 확인" />
                <input placeholder="주소" />
                <input placeholder="상세 주소" />
                {type === "teacher" && <input placeholder="지점명" />}
            </div>
        </div>
    )
}

export default Register;