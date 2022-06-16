import React, { Component } from 'react';

class FooterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div>
                <footer className='footer'>
                    <div className='row beige'>
                        <div className='d-flex flex-row-reverse'>
                            <small className='text-muted'>Powered by PAP © 2022</small>
                        </div>
                    </div>
                </footer>
            </div>
        );
    }
}

export default FooterComponent;