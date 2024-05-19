import {useEffect} from "react";
import {useAppDispatch, useAppSelector} from "../hooks";
import {listaPassword} from "../store/password-slice";
import "./password-manager.css"

function PasswordManager() {
    const dispatch = useAppDispatch();
    const {
        searchResult
    } = useAppSelector(state => state.password)

    useEffect(() => {
        dispatch(listaPassword())
    }, [])

    return (
        <div className={"passwords-layout"}>
            {/*<div className={"row"}>*/}
            {/*    {searchResult.map(x => {*/}
            {/*        return (*/}
            {/*            <div key={"" + x.id} className="col-12">{x.username}</div>*/}
            {/*        )*/}
            {/*    })}*/}
            {/*</div>*/}

            {}
            <div className="section">
                <div className="section-title">
                    Titolo Sezione
                </div>
                <div className="section-body">
                    <input type={"text"} className={"section-fill"}/>
                    <input type={"text"} className={"section-fill"}/>
                    <input type={"text"} className={"section-fill"}/>
                    <input type={"text"} className={"section-fill"}/>
                    <input type={"button"} value={"Bottone"}/>
                </div>
            </div>
            <div className="section">
                <div className="section-title">
                    Titolo Sezione
                </div>
            </div>
        </div>
    );
}

export default PasswordManager;