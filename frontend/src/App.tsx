import {useState} from 'react'
import warhammerLogo from '/warhammer.png'
import './App.css'
import {Button} from "flowbite-react";

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="flex flex-col items-center ">
      <div >
        <a href="https://www.warhammer-community.com/" target="_blank">
          <img src={warhammerLogo} className="logo" alt="Warhammer logo"/>
        </a>
      </div>
      <h1 className="m-10">Warhammer things</h1>
      <div className="card m-10">
        <Button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </Button>
      </div>
    </div>
  )
}

export default App
