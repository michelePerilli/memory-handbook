import React from 'react';
import './application.css';
import PasswordManager from "./pages/password-manager";
import TopNavbar from "./components/top-navbar/top-navbar";
import SideNavbar from "./components/side-navbar/side-navbar";

function Application() {
    return (
        <>
            <header>

                <TopNavbar></TopNavbar>
            </header>
            <main>
                <SideNavbar></SideNavbar>
                <PasswordManager></PasswordManager>
            </main>
            <footer>

            </footer>
        </>
    );
}

export default Application;
