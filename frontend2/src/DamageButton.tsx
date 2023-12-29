import React, { useState, useEffect } from 'react';
import { useAtomValue, useSetAtom } from 'jotai';
import { attackerid, damagenum, defenderid } from './Store';

const DamageButton = () => {
    const attacker = useAtomValue(attackerid);
    const defender = useAtomValue(defenderid);
    const setDamage = useSetAtom(damagenum);
    const calculateDamage = async () => {
        if (attacker === null || defender === null){return}
        try {
            const response = await fetch(`http://localhost:8080/getunit/${attacker}/${defender}`);
            const data = await response.json();
            setDamage(data)
          } catch (error) {
            console.error('Error fetching step 1 data:', error);
          }
       
        };


return (
    <div>
        <button onClick={() => calculateDamage()}>
        {"Roll Damage"}
        </button>
    </div>
);
};


export default DamageButton

