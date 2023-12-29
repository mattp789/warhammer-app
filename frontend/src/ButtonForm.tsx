import React, { useState, useEffect } from 'react';

const ApiRequestButtons = () => {
  const [apiData, setApiData] = useState([]);

  useEffect(() => {
    // Function to fetch data from the API
    const fetchData = async () => {
      try {
        // Replace 'YOUR_API_ENDPOINT' with your actual API endpoint
        const response = await fetch('http://localhost:8080/getalliances');
        const data = await response.json();
        setApiData(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    // Call the fetchData function to make the initial GET request on component load
    fetchData();
  }, []);

  return (
    <div>
      {apiData.map((item, index) => (
        <div key={index} className="button-group">
          <button onClick={() => console.log(`Button 1 clicked for ${item}`)}>
            {item}
          </button>
          <button onClick={() => console.log(`Button 2 clicked for ${item}`)}>
            {item}
          </button>
        </div>
      ))}
    </div>
  );
};

export default ApiRequestButtons;