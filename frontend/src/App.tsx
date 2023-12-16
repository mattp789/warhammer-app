import {useState} from 'react'
import warhammerLogo from '/warhammer.png'
import './App.css'

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
        <button className="bg-gray-500 hover:bg-gray-950 text-white font-bold py-2 px-4 rounded" onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
      </div>
    </div>
  )
}

export default App
