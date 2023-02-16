import React from 'react'
import axios from 'axios'
import '../App.css'
import {useParams} from 'react-router-dom'
import {Link} from 'react-router-dom'
import ButtonForm from './ButtonForm'

export function withRouter(Children) {
  return (props) => {
    const match = {params: useParams()}
    return <Children {...props} match={match}/>
  }
}

class PersonComponent extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      id: 0,
      firstName: '',
      lastName: '',
      avatar: '',
    }

    this.changeFirstName = this.changeFirstName.bind(this)
    this.changeLastName = this.changeLastName.bind(this)
    this.changeAvatar = this.changeAvatar.bind(this)
  }

  changeFirstName(event) {
    this.setState({firstName: event})
  }

  changeLastName(event) {
    this.setState({lastName: event})
  }

  changeAvatar(event) {
    this.setState({avatar: event})
  }

  delete = () => {
    axios
      .delete('/api/person/delete/' + this.state.id)
      .then((response) => {
        console.log(response)
      })
      .catch((error) => {
        console.log(error)
      })
  }

  update = () => {
    const {id, firstName, lastName, avatar} = this.state
    axios
      .put('/api/person/update/' + this.state.id, {
        id: id,
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

  componentDidMount() {
    axios
      .get('/api/person/get/' + this.props.match.params.id)
      .then((response) => {
        this.setState({
          id: response.data.id,
          firstName: response.data.firstName,
          lastName: response.data.lastName,
          avatar: response.data.avatar,
        })

        console.log(this.state.id)
        console.log(this.state.firstName)
        console.log(this.state.lastName)
        console.log(this.state.avatar)
      })
      .catch((error) => {
        console.log(error)
      })
  }

  render() {
    const ShowImage = ({data}) => <img src={`data:image/jpeg;base64,${data}`} width={100}  alt="avatar"/>
    return (
      <div>
        Person:
        <ButtonForm
          value={this.state.firstName}
          handleSubmit={this.changeFirstName}
        />
        <ButtonForm
          value={this.state.lastName}
          handleSubmit={this.changeLastName}
        />
        <ButtonForm
          value={<ShowImage data={this.state.avatar}/>}
          handleSubmit={this.changeAvatar}
        />
        <div>
          <Link to='/list-persons' className='App-button'>
            <span onClick={this.delete}>Delete person (Warning! Change permanent!)</span>
          </Link>
          <Link to='/list-persons' className='App-button'>
            <span onClick={this.update}>Update</span>
          </Link>
          <Link to='/list-persons' className='App-button'>
            Reject changes and go back
          </Link>
        </div>

      </div>
    )
  }
}

export default withRouter(PersonComponent)
