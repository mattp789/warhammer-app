import React from 'react';
import './App.css';
// import MyButton from './MyButton';
// import MyForm from './MyForm'
import ButtonForm from './ButtonForm'
import DamageButton from './DamageButton';
import { useAtomValue } from 'jotai';
import { damagenum } from './Store';

function App(){
  const damage = useAtomValue(damagenum)
  return (
    <div className='App'>
      <h1>AOS COMBAT CRUNCHER!</h1>
      <div style = {{
        color:"gold",
        fontWeight:"bold",
        fontSize:"2em"
    }}>Damage Dealt: {damage !== null?damage:""}</div>
      <div style = {{
        display:"flex",
        gap:300
      }}>
        <div>
          <h2> Attacker:</h2>
          <ButtonForm team = "attack" />
        </div>
        <div>
          <h2> Defender:</h2>
          <ButtonForm team = "defend"/>
        </div>
      </div>
      <br></br>
      <DamageButton/>
      
      
    </div>
  )
}

export default App;