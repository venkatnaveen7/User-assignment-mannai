import { useState } from "react";
const Loginform = (props) => {


    const [stateData, setStateData] = useState({
        name: '',
        email: ''
    });


    const submitUserForm = e => {

        e.preventDefault();
        props.submitHandler(stateData);
    }

    const nameChangeHandler = e => {
        setStateData({ ...stateData, name: e.target.value })

    }

    const mailChangeHandler = e => {
        //setStateData({ ...stateData,email: e.target.value })
        setStateData((prevState) => { return { ...prevState, email: e.target.value } })
    }

    return <div>Login Form

        <h1>Welcome</h1>
        <br>
        </br>
        <form onSubmit={submitUserForm}>
            <label>Full name</label>
            <input type="text" onChange={nameChangeHandler}></input>
            <br />
            <label>Email</label>
            <input type="email" onChange={mailChangeHandler}></input>
            <br />
            <button type="submit">Next

            </button>
        </form>
    </div>
}

export default Loginform