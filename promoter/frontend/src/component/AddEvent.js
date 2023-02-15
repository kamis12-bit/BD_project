import React from 'react'
import {Link} from 'react-router-dom'
import axios from 'axios'

class AddEvent extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      name: '',
      description: '',
      beginDate: '',
      endDate: '',
      archived: 0,
    }

    this.changeName = this.changeName.bind(this)
    this.changeDescription = this.changeDescription.bind(this)
    this.changeBeginDate = this.changeBeginDate.bind(this)
    this.changeEndDate = this.changeEndDate.bind(this)
  }

  changeName(event) {
    this.setState({name: event.target.value})
  }

  changeDescription(event) {
    this.setState({description: event.target.value})
  }

  changeBeginDate(event) {
    this.setState({beginDate: event.target.value})
  }

  changeEndDate(event) {
    this.setState({endDate: event.target.value})
  }

  send = () => {
    const {name, description, beginDate, endDate} = this.state
    axios
      .post('/api/event/create', {
        name: name,
        description: description,
        beginDate: beginDate,
        endDate: endDate,
        archived: 0,
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
        <h1>New Event:</h1>
        <p>
          <form>
            <label>
              <input type='text' onChange={this.changeName}/>
            </label>
            <label>
              <input type='text' onChange={this.changeDescription}/>
            </label>
            <label>
              <input type='datetime-local' onChange={this.changeBeginDate}/>
            </label>
            <label>
              <input type='datetime-local' onChange={this.changeEndDate}/>
            </label>
          </form>
        </p>
        <Link to='/main-view' className='App-button'>
          <span onClick={this.send}>Create event</span>
        </Link>
        <Link to='/main-view' className='App-button'>
          Go back
        </Link>
      </div>
    )
  }
}

export default AddEvent