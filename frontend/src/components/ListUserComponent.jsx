import React, { Component } from 'react';
import UserService from '../services/UserService';

class ListUserComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            users: []
        }
    }

    componentDidMount(){
        UserService.getUsers().then((res) => {
            this.setState({users: res.data});
        });
    }

    render() {
        return (
            <div>
                <h2 className='text-center'>Users list:</h2>
                <div className='row'>
                    <table className='table table-bordered'>
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Password</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.users.map(
                                    user => 
                                    <tr key = {user.id}>
                                        <td> {user.username}</td>
                                        <td> {user.password}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListUserComponent;