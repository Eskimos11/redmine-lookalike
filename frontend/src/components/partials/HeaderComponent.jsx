import React, { Component } from 'react';

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className=''>
                        <div className='dark-blue row'>
                            <div>Home | Administration | Help</div>
                        </div>
                        <div className='light-blue row'>
                            <div className='project-title'>
                                <h4>Redmine</h4>
                            </div>
                            <div className='menu-link-bar d-flex flex-row'>
                                <div className='menu-link p-1'>
                                    Overview
                                </div>

                                <div className='menu-link p-1'>
                                    Projects
                                </div>

                                <div className='menu-link p-1'>
                                    Activity
                                </div>

                                <div className='menu-link p-1'>
                                    Roadmap
                                </div>

                                <div className='menu-link p-1'>
                                    Issues
                                </div>

                                <div className='menu-link p-1'>
                                    News
                                </div>

                                <div className='menu-link p-1'>
                                    Wiki
                                </div>
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;