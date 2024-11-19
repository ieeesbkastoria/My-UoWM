require('dotenv').config()

const express = require('express')
const mongoose = require('mongoose')
const linkRoutes = require('./routes/links')
const userRoutes = require('./routes/user')

// express app
const app = express()

// middleware
app.use(express.json({ limit: '10mb' }));
app.use(express.urlencoded({ limit: '10mb', extended: true }));

require('http').maxHeaderSize = 16384; // Increase to 16KB


// routes
app.use('/api/links', linkRoutes)
app.use('/api/user', userRoutes)

app.use((req, res, next) => {
  console.log('Headers:', req.headers);
  next()
})



// connect to db
mongoose.connect(process.env.MONGO_URL)
  .then(() => {
    // listen for requests
    app.listen(process.env.PORT, () => {
      console.log('connected to db & listening on port', process.env.PORT)
    })
  })
  .catch((error) => {
    console.log(error)
  })
