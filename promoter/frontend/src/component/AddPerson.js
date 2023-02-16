import React from 'react'
import {Link} from 'react-router-dom'
import axios from 'axios'

const AddPerson = (props) => {
  const [selectedFile, setSelectedFile] = React.useState(null)
  const [preview, setPreview] = React.useState(null)
  const [firstName, setFirstName] = React.useState('')
  const [lastName, setLastName] = React.useState('')

  const changeFirstName = (event) => {
    setFirstName(event.target.value)
  }

  const changeLastName = (event) => {
    setLastName(event.target.value)
  }

  const changeHandler = (event) => {
    setSelectedFile(event.target.files[0])
    setPreview(URL.createObjectURL(event.target.files[0]))
  }

  const handleSubmission = async (event) => {
    event.preventDefault()

    console.log(selectedFile)
    console.log(firstName)
    console.log(lastName)

    const formData = new FormData()
    formData.append('avatar', selectedFile)
    formData.append('firstName', firstName)
    formData.append('lastName', lastName)

    try {
      const response = await axios.post('/api/person/create', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      })
      console.log(response)
    } catch (error) {
      console.log(error)
    }
  }

  return (
    <div>
      <h1>New Person:</h1>

      <form onSubmit={handleSubmission}>
        <p>First Name: </p>
        <label>
          <input type='text' onChange={changeFirstName}/>
        </label> <br/>

        <p>Last Name: </p>
        <label>
          <input type='text' onChange={changeLastName}/>
        </label> <br/>

        <p>Avatar: </p>
        <label>
          <input type='file' name='file' onChange={changeHandler} />
        </label> <br/> <br/>

        <div>
          {preview && (
            <img src={preview} alt='avatar' style={{width: '100px'}} />
          )}
        </div>

        <button type='submit' className='App-button'>
          Create person
        </button>
      </form>

      <Link to='/list-persons' className='App-button'>
        Go back
      </Link>
    </div>
  )
}

export default AddPerson
