require('dotenv').config()

const express = require('express')
const mongoose = require('mongoose')
const linkRoutes = require('./routes/links')
const userRoutes = require('./routes/user')

const cors = require('cors');

// express app
const app = express()

// middleware
app.use(cors());
app.use(express.json({ limit: '500mb' }));
app.use(express.urlencoded({ limit: '500mb', extended: true }));

// Log request headers to understand what's large
app.use((req, res, next) => {
  console.log('Request Headers:', req.headers);
  console.log('Cookie Length:', req.headers.cookie?.length);
  next();
});

// routes
app.use('/api/links', linkRoutes)
app.use('/api/user', userRoutes)

// connect to db
mongoose.connect(process.env.MONGO_URL)
  .then(() => {
    // listen for requests
    const server = app.listen(process.env.PORT, () => {
      server.maxHeadersCount = 2000; // Increase max headers
      server.headersTimeout = 60 * 1000; // Increase headers timeout
      console.log('connected to db & listening on port', process.env.PORT)
    })
  })
  .catch((error) => {
    console.log(error)
  })
