const express = require('express');

const app = express();
const port = 4000;

// Define your API routes here
app.get('/api/users', (req, res) => {
    // Handle GET request for /api/users
    const users = [
        { id: 1, name: 'John Doe' },
        { id: 2, name: 'Jane Smith' },
        { id: 3, name: 'Bob Johnson' }
    ];
    res.json(users);
});

app.post('/api/users', (req, res) => {
    // Handle POST request for /api/users
    const newUser = req.body;
    // Save the new user to the database or perform any other necessary operations
    res.status(201).json(newUser);
});

// Start the server
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});