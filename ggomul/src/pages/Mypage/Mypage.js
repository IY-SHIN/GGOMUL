import { useState } from "react";
import SEO from "../../components/SEO";
import "./Mypage.scss";

function Mypage() {
    const [nickname, setNickName] = useState("신우혁");
    console.log(setNickName);

    return (
        <>
            <SEO title="마이페이지" />
            <div className="mypage-container">
                <div className="mypage-box">
                    <div className="mypage-profile" />
                    <div className="mypage-nickname">{nickname}</div>
                </div>

                <div className="mypage-menubox">
                    <button>내정보</button>
                    <button>찜</button>
                    <button>예약/취소 내역</button>
                    <button>결제 내역</button>
                </div>
            </div>
        </>
    )
}

export default Mypage;