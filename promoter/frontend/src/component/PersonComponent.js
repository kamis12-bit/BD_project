import React from 'react'
import axios from 'axios'
import '../App.css'
import { useParams } from 'react-router-dom'
import GoToMenu from './GoToMenu'
import ButtonForm from './ButtonForm'

export function withRouter(Children) {
  return (props) => {
    const match = { params: useParams() }
    return <Children {...props} match={match} />
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
    this.setState({ firstName: event })
  }
  changeLastName(event) {
    this.setState({ lastName: event })
  }
  changeAvatar(event) {
    this.setState({ avatar: event })
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
    return (
      <div>
        <p>
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
            value={this.state.avatar}
            handleSubmit={this.changeAvatar}
          />
        </p>
        <GoToMenu />
      </div>
    )
  }
}

export default withRouter(PersonComponent)
