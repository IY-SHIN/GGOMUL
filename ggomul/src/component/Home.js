import React from "react";
import Header from "../components/Header";
import Footer from "../components/Footer";

function Home() {
    return (
        <>
            <Header />
            <div className="Main1">
                <img className="main1" src="img/main1.jpg" alt="main1" />
            </div>
            <Footer />
        </>
    )
}

export default Home;