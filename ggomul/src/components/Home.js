import React from "react";
import Header from "./Header";
import Footer from "./Footer";

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