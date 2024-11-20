const Link = require('../models/linkModel')
const mongoose = require('mongoose')

// get all links
const getLinks = async (req, res) => {
  const user_id = req.user._id

  const links = await Link.find({ }).sort({ createdAt: -1 })

  res.status(200).json(links)
}

// get a single link
const getLink = async (req, res) => {
  const { id } = req.params

  if (!mongoose.Types.ObjectId.isValid(id)) {
    return res.status(404).json({ error: 'No such Hyperlink' })
  }

  const link = await Link.findById(id)

  if (!link) {
    return res.status(404).json({ error: 'No such Hyperlink' })
  }

  res.status(200).json(link)
}


// create new link
const createLink = async (req, res) => {
  const { title, url } = req.body

  let emptyFields = []

  if (!title) {
    emptyFields.push('title')
  }
  if (!url) {
    emptyFields.push('link')
  }
  if (emptyFields.length > 0) {
    return res.status(400).json({ error: 'Please fill in all the fields', emptyFields })
  }

  // add doc to db
  try {
    const user_id = req.user._id
    const link = await Link.create({ title, url, user_id })
    res.status(200).json(link)
  } catch (error) {
    res.status(400).json({ error: error.message })
  }
}

// delete a link
const deleteLink = async (req, res) => {
  const { id } = req.params

  if (!mongoose.Types.ObjectId.isValid(id)) {
    return res.status(404).json({ error: 'No such hyperlink' })
  }

  const link = await Link.findOneAndDelete({ _id: id })

  if (!link) {
    return res.status(400).json({ error: 'No such hyperlink' })
  }

  res.status(200).json(link)
}

// update a link
const updateLink = async (req, res) => {
  const { id } = req.params

  if (!mongoose.Types.ObjectId.isValid(id)) {
    return res.status(404).json({ error: 'No such hyperlink' })
  }

  const link = await Link.findOneAndUpdate({ _id: id }, {
    ...req.body
  })

  if (!link) {
    return res.status(400).json({ error: 'No such hyperlink' })
  }

  res.status(200).json(link)
}


module.exports = {
  getLinks,
  getLink,
  createLink,
  deleteLink,
  updateLink,
}
