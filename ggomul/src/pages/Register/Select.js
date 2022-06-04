import { useNavigate } from 'react-router-dom';
import SEO from '../../components/SEO';
import './Select.scss';

function Select() {
    const navigate = useNavigate();

    return (
        <>
            <SEO title="회원가입" />
            <div className="select-container">
                <button onClick={() => navigate("/register/member")}>회원으로 회원가입</button>
                <button className="select-teacher"
                    onClick={() => navigate("/register/teacher")}>강사로 회원가입</button>
            </div>
        </>
    )
}

export default Select;