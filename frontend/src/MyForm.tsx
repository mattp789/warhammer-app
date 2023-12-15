import React, { useState } from 'react';

const ApiRequestComponent = () => {
  const [input1, setInput1] = useState('');
  const [input2, setInput2] = useState('');
  const [response, setResponse] = useState('');


  const handleInputChange1 = (e) => {
    setInput1(e.target.value);
  };

  const handleInputChange2 = (e) => {
    setInput2(e.target.value);
  };
  const [showHeading, setShowHeading] = useState(false);
  
  const handleApiRequest = async () => {
    try {
      // Replace 'YOUR_API_ENDPOINT' with your actual API endpoint
      const url = `http://localhost:8080/getunit/${input1}/${input2}`;
      const response = await fetch(url);

      const data = await response.json();
      setResponse(JSON.stringify(data));
    } catch (error) {
      console.error('Error making API request:', error);
      setResponse('Error making API request');
    }
    setShowHeading(true);
  };

  return (
    <div>
      <form>
        <label>
          Input 1:
          <input type="text" value={input1} onChange={handleInputChange1} />
        </label>
      </form>

      <form>
        <label>
          Input 2:
          <input type="text" value={input2} onChange={handleInputChange2} />
        </label>
      </form>

      <button onClick={handleApiRequest}>Calculate Damage</button>

      <div>
        {showHeading && <h1>Damage Dealt!</h1>}
        <pre>{response}</pre>
      </div>
    </div>
  );
};

export default ApiRequestComponent;