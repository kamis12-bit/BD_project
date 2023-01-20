import React, {Component} from "react";
import axios from "axios";

class PersonComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: {},
            firstName: {},
            lastName: {},
            avatar: {}
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/person/1")
            .then(response => {
                this.setState({
                    id: response.data.id,
                    firstName: response.data.firstName,
                    lastName: response.data.lastName,
                    avatar: response.data.avatar
                });

                console.log(this.state.id);
                console.log(this.state.firstName);
                console.log(this.state.lastName);
                console.log(this.state.avatar);
            });
    }

    render() {
        return (
            <div>
                <h1>Person</h1>
            </div>
        );
    }
}

export default PersonComponent;