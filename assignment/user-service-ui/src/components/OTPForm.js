
import { useState } from "react"

const OTPForm=(props)=>{

const [otp,setOtp]=useState()

const otpChangeHandler=e=>{
    setOtp((e.target.value));
}

const submitHandler=e=>{
    e.preventDefault()
    props.otpSubmitHandler(otp)
}

    return <div>
        <h3>OTP has been sent to the mail.Please Enter OTP</h3>
        <form onSubmit={submitHandler}>
            <label>OTP</label>
            <input type="number" maxLength="6" onChange={otpChangeHandler} value={otp}></input>
            <button>Submit</button>
        </form>
    </div>
}

export default OTPForm;