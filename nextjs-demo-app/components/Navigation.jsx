import Link from 'next/link'

const nav_elements = [
    { "text": "About", "link": "/about" },
    { "text": "Services", "link": "/services" }
]

function Navigation() {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container">
                <a className="navbar-brand" href="/">My Users Demo App</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarColor02">
                    <ul className="navbar-nav ms-auto">
                        {nav_elements.map((element, index) => {
                            return (
                                <li key={index} className='nav-item'>
                                    <Link className='nav-link' href={element.link}>{element.text}</Link>
                                </li>
                            )
                        })}
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default Navigation