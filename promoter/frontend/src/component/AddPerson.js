import React from 'react'
import {Link} from 'react-router-dom'
import axios from 'axios'

class AddPerson extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      firstName: '',
      lastName: '',
      avatar: '',
    }

    this.changeFirstName = this.changeFirstName.bind(this)
    this.changeLastName = this.changeLastName.bind(this)
    this.changeAvatar = this.changeAvatar.bind(this)
  }

  changeFirstName(event) {
    this.setState({firstName: event.target.value})
  }

  changeLastName(event) {
    this.setState({lastName: event.target.value})
  }

  changeAvatar(event) {
    this.setState({avatar: event.target.value})
  }

  send = () => {
    const {firstName, lastName, avatar} = this.state
    axios
      .post('/api/person/create', {
        firstName: firstName,
        lastName: lastName,
        avatar: avatar,
      })
      .then((response) => {
        console.log(response)
      })
      .catch((error) => {
        console.log(error)
      })
  }

  render() {
    return (
      <div>
        <h1>New Person:</h1>
        <p>
          <form>
            <label>
              <input type='text' onChange={this.changeFirstName}/>
            </label>
            <label>
              <input type='text' onChange={this.changeLastName}/>
            </label>
            <label>
              <input type='text' onChange={this.changeAvatar}/>
            </label>
          </form>
        </p>
        <Link to='/list-persons' className='App-button'>
          <span onClick={this.send}>Create person</span>
        </Link>
        <Link to='/list-persons' className='App-button'>
          Go back
        </Link>
      </div>
    )
  }
}

export default AddPerson
