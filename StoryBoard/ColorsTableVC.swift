//
//  ColorsTableVC.swift
//  StoryBoard
//
//  Created by MACBOOK on 23.02.23.
//

import UIKit

class ColorsTableVC: UIViewController  {
    
    var colors: [UIColor] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        addRandomColors()
        // Do any additional setup after loading the view.
    }
    
    func addRandomColors(){
        for _ in 0..<50{
            colors.append(createRandomColor())
        }
    }
    
    func createRandomColor() -> UIColor {
        let color = UIColor(red: CGFloat.random(in: 0...1), green: CGFloat.random(in:0...1), blue: CGFloat.random(in:0...1), alpha: 1)
        return color
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let destVC = segue.destination as! ColorsDetialVC
        destVC.color = sender as? UIColor
    }
}

extension ColorsTableVC: UITableViewDelegate, UITableViewDataSource{
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return colors.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "ColorCell") else {
            return UITableViewCell()
        }
        cell.backgroundColor = colors[indexPath.row]
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "ToColorDetailsVC", sender: colors[indexPath.row])
    }
}
