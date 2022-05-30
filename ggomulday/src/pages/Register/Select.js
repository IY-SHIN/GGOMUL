import { useNavigate } from 'react-router-dom';
import './Select.scss';

function Select () {
    const navigate = useNavigate();

    return (
        <div className="select-container">
            <button onClick={() => navigate("/Register/member")}>회원으로 회원가입</button>
            <button className="select-teacher"
            onClick={() => navigate("/Register/teacher")}>강사로 회원가입</button>
        </div>
    )
}

export default Select;