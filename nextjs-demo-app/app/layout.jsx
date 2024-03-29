import './globals.css'
import Navigation from '@/components/Navigation'

export const metadata = {
  title: 'My Demo Next App',
  description: 'Generated by create next app',
}



export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <head>
        <link rel='stylesheet' href='https://bootswatch.com/5/darkly/bootstrap.min.css' />
      </head>
      <body>
        <Navigation />
        <div className='container p-4'>
          {children}
        </div>
      </body>
    </html>
  )
}
