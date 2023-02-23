const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

// middleware to parse request body
app.use(bodyParser.urlencoded({ extended: true }));

// homepage route
app.get('/', (req, res) => {
  res.send('Welcome to my website!');
});

// login page route
app.get('/login', (req, res) => {
  res.send(`
    <h1>Login</h1>
    <form method="POST" action="/login">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username"><br>

      <label for="password">Password:</label>
      <input type="password" id="password" name="password"><br>

      <button type="submit">Submit</button>
    </form>
  `);
});

// handle login form submission
app.post('/login', (req, res) => {
  const { username, password } = req.body;
  
  // check if username and password are valid
  if (username === 'user' && password === 'password') {
    res.send('Login successful!');
  } else {
    res.send('Invalid username or password.');
  }
});

// start server
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
