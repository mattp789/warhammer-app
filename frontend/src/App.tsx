import {useEffect, useState} from 'react'
import warhammerLogo from '/warhammer.png'
import './App.css'
import {Button, Card} from "flowbite-react";

function App() {
  const [count, setCount] = useState(0)
  const [alliances, setAlliances] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/getalliances')
      .then(response => response.json())
      .then(data => setAlliances(data))
      .catch(error => console.error('Error fetching alliances:', error));
  }, []);

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
        {alliances.map((alliance) => (
          <div className="flex m-4 place-content-center"
               key={alliance}>
            <Button onClick={() => setCount((count) => count + 1)}>
              {alliance}
            </Button>
          </div>
        ))}
      </Card>
    </div>
  )
}

export default App
