import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Application from './application';
import reportWebVitals from './reportWebVitals';
import {Provider} from "react-redux";
import store from "./store/Store";

const root = ReactDOM.createRoot(
    document.getElementById('body') as HTMLElement
);
root.render(
    <Provider store={store}>
        <React.StrictMode>
            <Application/>
        </React.StrictMode>
    </Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals(console.log);
