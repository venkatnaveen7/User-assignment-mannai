
import './App.css';
import Loginform from './components/LoginForm';
import OTPForm from './components/OTPForm'
import axios from 'axios';
import { useState } from 'react';

function App() {

  const [showLoginForm, setShowLoginForm] = useState(true);

  const [formData, setFormData] = useState({
    fullName: "",
    email: ""
  })

  const submitHandler = data => {
    let reqData={ email: data.email, fullName: data.name}
    
    setShowLoginForm(false);

    axios.post("http://localhost:9890/saveUser", reqData).then(res => {
      setFormData(reqData)
      
    })

  }

const completeSaveUser=()=>{
  axios.post("http://localhost:9890/completeUserSave",formData).then(res=>{
    alert(res.data);
  })
}

  const otpSubmitHandler = otpData => {
    //alert(otpData)
    axios.post("http://localhost:9890/validateOTP?otp=" + otpData, formData).then(res => {
      if(res.data===true){
        completeSaveUser();
      }
    })


  }


  return (
    <div className="App">
      {showLoginForm ?
        <Loginform submitHandler={submitHandler}></Loginform>
        : <OTPForm otpSubmitHandler={otpSubmitHandler} mail={formData.email}></OTPForm>}

    </div>
  );
}

export default App;
