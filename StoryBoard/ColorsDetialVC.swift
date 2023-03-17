//
//  ColorsDetialVC.swift
//  StoryBoard
//
//  Created by MACBOOK on 23.02.23.
//

import UIKit

class ColorsDetialVC: UIViewController {

    var color: UIColor?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        view.backgroundColor = color ?? .blue
    }
    
}
