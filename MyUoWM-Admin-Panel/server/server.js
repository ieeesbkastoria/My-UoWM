require('dotenv').config()

const express = require('express')
const mongoose = require('mongoose')
const linkRoutes = require('./routes/links')
const userRoutes = require('./routes/user')

// express app
const app = express()

// middleware
app.use(express.json({ limit: '1mb' }));
app.use(express.urlencoded({ limit: '1mb', extended: true }));


// routes
app.use('/api/links', linkRoutes)
app.use('/api/user', userRoutes)

app.use((req, res, next) => {
  console.log(req.path, req.method)
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
