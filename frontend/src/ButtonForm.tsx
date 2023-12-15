import React, { useState, useEffect } from 'react';

const MyComponent = () => {
  const [step1Data, setStep1Data] = useState([]);
  const [step2Data, setStep2Data] = useState({});
  const [step3Data, setStep3Data] = useState({});
  const [expandedButtons1, setExpandedButtons1] = useState({});
  const [expandedButtons2, setExpandedButtons2] = useState({});

  useEffect(() => {
    // Step 1: Initial GET request
    const fetchDataStep1 = async () => {
      try {
        const response = await fetch('http://localhost:8080/getalliances');
        const data = await response.json();
        setStep1Data(data);
      } catch (error) {
        console.error('Error fetching step 1 data:', error);
      }
    };

    fetchDataStep1();
  }, []);

  const handleStep1ButtonClick = async (item) => {
    // Step 2: Subsequent GET request based on step 1 data
    if (!expandedButtons1[item]) {
      try {
        const response = await fetch(`http://localhost:8080/getarmy/${item}`.toLowerCase());
        const data = await response.json();
        setStep2Data({ ...step2Data, [item]: data });
      } catch (error) {
        console.error('Error fetching step 2 data:', error);
      }
    }

    // Toggle the expanded state for step 2
    setExpandedButtons1({ ...expandedButtons1, [item]: !expandedButtons1[item] });
  };

  const handleStep2ButtonClick = async (item, id) => {
    // Step 3: Subsequent GET request based on step 2 data
    if (!expandedButtons2[item]) {
      try {
        const response = await fetch(`http://localhost:8080/getunits/${id}`.toLowerCase());
        const data = await response.json();
        setStep3Data({ ...step3Data, [item]: data });
      } catch (error) {
        console.error('Error fetching step 3 data:', error);
      }
    }

    // Toggle the expanded state for step 3
    setExpandedButtons2({ ...expandedButtons2, [item]: !expandedButtons2[item] });
  };

  return (
    <div>
      {/* Step 1: Display buttons for the initial data */}
      {step1Data.map((item, index) => (
        <div key={index}>
          <button onClick={() => handleStep1ButtonClick(item)}>
            {item}
          </button>

          {/* Step 2: Display buttons for the data from Step 2 */}
          {step2Data[item] && expandedButtons1[item] && (
            <div>
              {step2Data[item].map(({ id, name }) => (
                <div key={id}>
                  <button onClick={() => handleStep2ButtonClick(name, id)}>
                    {name}
                  </button>

                  {/* Step 3: Display buttons for the data from Step 3 */}
                  {step3Data[name] && expandedButtons2[name] && (
                    <div>
                      {step3Data[name].map(({ id: thirdId, name: thirdName }) => (
                        <div key={thirdId}>
                          {/* Display buttons for the third level */}
                          <button>{thirdName}</button>
                        </div>
                      ))}
                    </div>
                  )}
                </div>
              ))}
            </div>
          )}
        </div>
      ))}
    </div>
  );
};

export default MyComponent;


// import React, { useState, useEffect } from 'react';

// const App = () => {
//   const [data, setData] = useState([]);
//   const [subData, setSubData] = useState({});
//   const [isCollapsed, setIsCollapsed] = useState({});

//   // Step 1: Initial GET request
//   useEffect(() => {
//     const fetchData = async () => {
//       try {
//         const response = await fetch('http://localhost:8080/getalliances');
//         const result = await response.json();
//         setData(result);
//       } catch (error) {
//         console.error('Error fetching data:', error);
//       }
//     };

//     fetchData();
//   }, []);

//   // Step 2: Function for handling sub-data GET request
//   const handleSubData = async (item) => {
//     try {
//       // Toggle the collapse state
//       setIsCollapsed((prevCollapse) => ({ ...prevCollapse, [item]: !prevCollapse[item] }));

//       // Only fetch data if it's collapsed (to avoid unnecessary requests)
//       if (!subData[item] && !isCollapsed[item]) {
//         const response = await fetch(`http://localhost:8080/getunits/${item}`);
//         const result = await response.json();
//         setSubData((prevData) => ({ ...prevData, [item]: result }));
//       }
//     } catch (error) {
//       console.error('Error fetching sub-data:', error);
//     }
//   };

//   return (
//     <div>
//       {/* Step 1: Display two sets of buttons for each string in the initial data */}
//       {data.map((item) => (
//         <div key={item}>
//           <div>
//             {/* Set 1: Buttons for each string */}
//             <button onClick={() => handleSubData(item)}>
//               {isCollapsed[item] ? `Show ${item} Data` : `Hide ${item} Data`}
//             </button>

//             {/* Set 2: Buttons for each string */}
//             <button onClick={() => handleSubData(item)}>
//               {isCollapsed[item] ? `Show ${item} Data` : `Hide ${item} Data`}
//             </button>
//           </div>

//           {/* Display buttons for each name in the sub-data */}
//           {subData[item] && !isCollapsed[item] ? (
//             Array.isArray(subData[item]) ? (
//               subData[item].map((subItem) => (
//                 <div key={subItem.id}>
//                   <button>{subItem.name}</button>
//                 </div>
//               ))
//             ) : (
//               Object.values(subData[item]).map((subItem) => (
//                 <div key={subItem.id}>
//                   <button>{subItem.name}</button>
//                 </div>
//               ))
//             )
//           ) : null}
//         </div>
//       ))}
//     </div>
//   );
// };

// export default App;