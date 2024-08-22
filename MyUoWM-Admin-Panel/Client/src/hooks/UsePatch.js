const UsePatch = (url, data) => {

  fetch(url, {
    method: 'PATCH',
    headers: {
      'Content-Type': 'application/json', // Ensure this is correct
    },
    body: JSON.stringify(data),
  })
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));


  return { data };
}
 
export default UsePatch;
