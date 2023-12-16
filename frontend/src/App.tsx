import {useState} from 'react'
import warhammerLogo from '/warhammer.png'
import './App.css'
import {Button, Card} from "flowbite-react";

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="flex flex-col items-center">
      <div>
        <a href="https://www.warhammer-community.com/" target="_blank">
          <img src={warhammerLogo} className="logo" alt="Warhammer logo"/>
        </a>
      </div>
      <Card className="m-4">
        <h1 className="m-4">Warhammer things</h1>
        <div className="flex m-4 place-content-center">
          <Button onClick={() => setCount((count) => count + 1)}>
            count is {count}
          </Button>
        </div>
      </Card>
      <Card className="m-4">
        <h1 className="m-4">Roll the Dice!</h1>
      </Card>
    </div>
  )
}

export default App
