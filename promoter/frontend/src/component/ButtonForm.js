import React from 'react'
import '../App.css'

class ButtonForm extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      viewForm: false,
      value: '',
    }

    this.handleSubmit = this.handleSubmit.bind(this)
    this.handleChange = this.handleChange.bind(this)
  }

  handleSubmit(event) {
    this.setState({ viewForm: false })
    this.props.handleSubmit(this.state.value)
  }

  handleChange(event) {
    this.setState({ value: event.target.value })
  }

  render() {
    if (this.state.viewForm) {
      return (
        <p>
          <form onSubmit={this.handleSubmit}>
            <label>
              {this.props.value}
              <input type='text' onChange={this.handleChange} />
            </label>
            <input type='submit' value='Submit' />
          </form>
        </p>
      )
    }
    return (
      <button
        className='App-button'
        onClick={() => this.setState({ viewForm: true })}
      >
        {this.props.value}
      </button>
    )
  }
}

export default ButtonForm
